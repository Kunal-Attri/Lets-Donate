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

public final class DashboardItemAbPosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView abneg;

  @NonNull
  public final TextView abpos;

  @NonNull
  public final TextView aneg;

  @NonNull
  public final TextView apos;

  @NonNull
  public final TextView bneg;

  @NonNull
  public final TextView bpos;

  @NonNull
  public final MaterialCardView cardViewContent;

  @NonNull
  public final TextView oneg;

  @NonNull
  public final TextView opos;

  private DashboardItemAbPosBinding(@NonNull ConstraintLayout rootView, @NonNull TextView abneg,
      @NonNull TextView abpos, @NonNull TextView aneg, @NonNull TextView apos,
      @NonNull TextView bneg, @NonNull TextView bpos, @NonNull MaterialCardView cardViewContent,
      @NonNull TextView oneg, @NonNull TextView opos) {
    this.rootView = rootView;
    this.abneg = abneg;
    this.abpos = abpos;
    this.aneg = aneg;
    this.apos = apos;
    this.bneg = bneg;
    this.bpos = bpos;
    this.cardViewContent = cardViewContent;
    this.oneg = oneg;
    this.opos = opos;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DashboardItemAbPosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DashboardItemAbPosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dashboard_item_ab_pos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DashboardItemAbPosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.abneg;
      TextView abneg = ViewBindings.findChildViewById(rootView, id);
      if (abneg == null) {
        break missingId;
      }

      id = R.id.abpos;
      TextView abpos = ViewBindings.findChildViewById(rootView, id);
      if (abpos == null) {
        break missingId;
      }

      id = R.id.aneg;
      TextView aneg = ViewBindings.findChildViewById(rootView, id);
      if (aneg == null) {
        break missingId;
      }

      id = R.id.apos;
      TextView apos = ViewBindings.findChildViewById(rootView, id);
      if (apos == null) {
        break missingId;
      }

      id = R.id.bneg;
      TextView bneg = ViewBindings.findChildViewById(rootView, id);
      if (bneg == null) {
        break missingId;
      }

      id = R.id.bpos;
      TextView bpos = ViewBindings.findChildViewById(rootView, id);
      if (bpos == null) {
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

      id = R.id.opos;
      TextView opos = ViewBindings.findChildViewById(rootView, id);
      if (opos == null) {
        break missingId;
      }

      return new DashboardItemAbPosBinding((ConstraintLayout) rootView, abneg, abpos, aneg, apos,
          bneg, bpos, cardViewContent, oneg, opos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
