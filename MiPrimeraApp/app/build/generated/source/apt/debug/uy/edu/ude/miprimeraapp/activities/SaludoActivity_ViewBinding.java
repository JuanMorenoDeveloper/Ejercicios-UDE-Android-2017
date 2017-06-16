// Generated code from Butter Knife. Do not modify!
package uy.edu.ude.miprimeraapp.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import uy.edu.ude.miprimeraapp.R;

public class SaludoActivity_ViewBinding implements Unbinder {
  private SaludoActivity target;

  @UiThread
  public SaludoActivity_ViewBinding(SaludoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SaludoActivity_ViewBinding(SaludoActivity target, View source) {
    this.target = target;

    target.txtSaludo = Utils.findRequiredViewAsType(source, R.id.txtSaludo, "field 'txtSaludo'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SaludoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtSaludo = null;
  }
}
