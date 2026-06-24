package com.avozdedeus.avozdedeusjpc.audio.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class AudioKeyTest {
    @Test
    fun `musicalKeyOf parses major sharp and minor labels`() {
        assertEquals("C", musicalKeyOf("C")?.label)
        assertEquals("C#", musicalKeyOf("C#")?.label)
        assertEquals("C-", musicalKeyOf("C-")?.label)
        assertEquals("C#-", musicalKeyOf("C#-")?.label)
        assertNull(musicalKeyOf("--"))
    }

    @Test
    fun `transpose uses tone slider value as musical tones for key display`() {
        assertEquals("C", transpose("C", 0f))
        assertEquals("C#", transpose("C", 0.5f))
        assertEquals("D", transpose("C", 1f))
        assertEquals("B", transpose("C", -0.5f))
    }

    @Test
    fun `transpose preserves minor suffix and wraps chromatic edges`() {
        assertEquals("C", transpose("B", 0.5f))
        assertEquals("F", transpose("E", 0.5f))
        assertEquals("C#-", transpose("C-", 0.5f))
        assertEquals("C#-", transpose("B-", 1f))
    }

    @Test
    fun `audioKeyDisplay shows placeholders without detected key`() {
        val display = audioKeyDisplay(null, 1f)

        assertEquals("--", display.sourceLabel)
        assertEquals("--", display.targetLabel)
    }

    private fun transpose(label: String, toneSliderValue: Float): String {
        return formatMusicalKey(
            transposeMusicalKeyByToneSliderValue(
                musicalKeyOf(label),
                toneSliderValue
            )
        )
    }
}
