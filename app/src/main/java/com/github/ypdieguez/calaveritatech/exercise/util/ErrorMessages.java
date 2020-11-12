package com.github.ypdieguez.calaveritatech.exercise.util;

import androidx.annotation.NonNull;

import com.github.ypdieguez.calaveritatech.exercise.R;

public final class ErrorMessages {
    private static final int GENERIC_ERROR = R.string.generic_error;
    private static final int FAILED_TO_CONNECT = R.string.failed_to_connect;

    public static int parse(@NonNull String msg) {
        if (msg.toLowerCase().contains("failed to connect")) {
            return FAILED_TO_CONNECT;
        } else {
            return GENERIC_ERROR;
        }
    }
}
