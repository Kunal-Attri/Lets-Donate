// Generated by view binder compiler. Do not edit!
package com.kunalattri.letsdonate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.kunalattri.letsdonate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DashboardItemANegBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView aneg;

  @NonNull
  public final MaterialCardView cardViewContent;

  @NonNull
  public final TextView oneg;

  private DashboardItemANegBinding(@NonNull ConstraintLayout rootView, @NonNull TextView aneg,
      @NonNull MaterialCardView cardViewContent, @NonNull TextView oneg) {
    this.rootView = rootView;
    this.aneg = aneg;
    this.cardViewContent = cardViewContent;
    this.oneg = oneg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DashboardItemANegBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DashboardItemANegBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dashboard_item_a_neg, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DashboardItemANegBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aneg;
      TextView aneg = ViewBindings.findChildViewById(rootView, id);
      if (aneg == null) {
        break missingId;
      }

      id = R.id.cardViewContent;
      MaterialCardView cardViewContent = ViewBindings.findChildViewById(rootView, id);
      if (cardViewContent == null) {
        break missingId;
      }

      id = R.id.oneg;
      TextView oneg = ViewBindings.findChildViewById(rootView, id);
      if (oneg == null) {
        break missingId;
      }

      return new DashboardItemANegBinding((ConstraintLayout) rootView, aneg, cardViewContent, oneg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}