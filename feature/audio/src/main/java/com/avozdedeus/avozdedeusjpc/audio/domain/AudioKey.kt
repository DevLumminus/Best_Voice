package com.avozdedeus.avozdedeusjpc.audio.domain

import kotlin.math.roundToInt

private val AmericanKeyNotes = listOf(
    "C",
    "C#",
    "D",
    "D#",
    "E",
    "F",
    "F#",
    "G",
    "G#",
    "A",
    "A#",
    "B"
)

data class MusicalKey(
    val noteIndex: Int,
    val isMinor: Boolean = false
) {
    init {
        require(noteIndex in AmericanKeyNotes.indices) {
            "noteIndex must be between 0 and 11."
        }
    }

    val label: String
        get() = AmericanKeyNotes[noteIndex] + if (isMinor) "-" else ""
}

data class AudioKeyDisplay(
    val sourceLabel: String,
    val targetLabel: String
)

fun musicalKeyOf(label: String): MusicalKey? {
    val normalizedLabel = label.trim()
    if (normalizedLabel.isEmpty()) {
        return null
    }

    val isMinor = normalizedLabel.endsWith("-")
    val noteLabel = if (isMinor) {
        normalizedLabel.dropLast(1)
    } else {
        normalizedLabel
    }
    val noteIndex = AmericanKeyNotes.indexOf(noteLabel)
    if (noteIndex < 0) {
        return null
    }

    return MusicalKey(
        noteIndex = noteIndex,
        isMinor = isMinor
    )
}

fun formatMusicalKey(key: MusicalKey?): String {
    return key?.label ?: "--"
}

fun transposeMusicalKeyByToneSliderValue(
    key: MusicalKey?,
    toneSliderValue: Float
): MusicalKey? {
    if (key == null) {
        return null
    }

    val semitoneOffset = (toneSliderValue * 2f).roundToInt()
    return key.copy(
        noteIndex = floorMod(key.noteIndex + semitoneOffset, AmericanKeyNotes.size)
    )
}

fun audioKeyDisplay(
    sourceKey: MusicalKey?,
    toneSliderValue: Float
): AudioKeyDisplay {
    return AudioKeyDisplay(
        sourceLabel = formatMusicalKey(sourceKey),
        targetLabel = formatMusicalKey(
            transposeMusicalKeyByToneSliderValue(sourceKey, toneSliderValue)
        )
    )
}

private fun floorMod(value: Int, divisor: Int): Int {
    return ((value % divisor) + divisor) % divisor
}
