package com.natali_pi.home_money.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.natali_pi.home_money.BaseActivity;
import com.natali_pi.home_money.BasePresenter;
import com.natali_pi.home_money.R;
import com.natali_pi.home_money.main.MainActivity;
import com.natali_pi.home_money.models.Human;
import com.natali_pi.home_money.utils.Api;
import com.natali_pi.home_money.utils.BaseAPI;
import com.natali_pi.home_money.utils.DataBase;
import com.natali_pi.home_money.utils.OneButtonDialog;

public class LoginPresenter extends BasePresenter {
LoginActivity activity;
    private BaseAPI api;



    public LoginPresenter(LoginActivity activity) {
        this.activity = activity;
        api = new Api();
    }
public void forgotPassword(String email){
        //TODO: Add request
}

public void login(Human human){
    api.login(human).subscribe(getObserver(true, (data)->{
        //TODO: Add message show on error
        DataBase.getInstance().login(data);
        activity.toMainActivity();
    }));
}
    @Override
    protected BaseActivity getView() {
        return activity;
    }
}
