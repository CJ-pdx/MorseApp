package edu.pcc.chris.morseapp;

import android.content.Context;

/**
 * An object representing a morse letter/number.
 */

public class MorseLetter {
    private Integer imageId;
    private Integer soundId;
    private Integer buttonId;
    private Integer labelId;
    private Context context;

    MorseLetter(Context context, Integer imageId,
                Integer soundId, Integer buttonId,
                Integer labelId) {

        this.context = context;
        this.imageId = imageId;
        this.soundId = soundId;
        this.buttonId = buttonId;
        this.labelId = labelId;
    }

    /**
     * Accessor methods
     * @return imageId, soundId, labelId, buttonId
     */
    public Integer getImageId() {
        return imageId;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    // Used by grid.setAdapter(new ArrayAdapter<MorseLetter>())
    public String toString() {
        return context.getString(buttonId);
    }

}
