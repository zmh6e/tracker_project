// Generated by view binder compiler. Do not edit!
package com.example.communityengagementtracker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.communityengagementtracker.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class HomePageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button engagementButton;

  @NonNull
  public final Button logoutButton;

  @NonNull
  public final Button requestsButton;

  private HomePageBinding(@NonNull ConstraintLayout rootView, @NonNull Button engagementButton,
      @NonNull Button logoutButton, @NonNull Button requestsButton) {
    this.rootView = rootView;
    this.engagementButton = engagementButton;
    this.logoutButton = logoutButton;
    this.requestsButton = requestsButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HomePageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomePageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.home_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomePageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.engagementButton;
      Button engagementButton = ViewBindings.findChildViewById(rootView, id);
      if (engagementButton == null) {
        break missingId;
      }

      id = R.id.logoutButton;
      Button logoutButton = ViewBindings.findChildViewById(rootView, id);
      if (logoutButton == null) {
        break missingId;
      }

      id = R.id.requestsButton;
      Button requestsButton = ViewBindings.findChildViewById(rootView, id);
      if (requestsButton == null) {
        break missingId;
      }

      return new HomePageBinding((ConstraintLayout) rootView, engagementButton, logoutButton,
          requestsButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
