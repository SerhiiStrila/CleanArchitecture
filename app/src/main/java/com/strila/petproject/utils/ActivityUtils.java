package com.strila.petproject.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;

import com.strila.petproject.R;

import static dagger.internal.Preconditions.checkNotNull;

public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id = R.id.container. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment,
                                                 boolean addBackStack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        String tag = fragment.getClass().getName();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.replace(R.id.container, fragment, tag);
        transaction.commit();
    }

    public static void addFragmentInActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment,
                                             boolean addBackStack) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        String tag = fragment.getClass().getName();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.add(R.id.container, fragment, tag);
        transaction.commit();
    }

}
