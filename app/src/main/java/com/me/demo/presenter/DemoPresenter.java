package com.me.demo.presenter;

import com.me.demo.model.DemoModel;
import com.me.demo.view.loginView;

public class DemoPresenter implements onLogin {

    loginView loginView;

    public DemoPresenter(loginView loginView) {
        this.loginView = loginView;
    }

    private void validateNameAndPassword(String Name, String Password){
        if (Name.isEmpty() || Password.isEmpty()) {
            loginView.isNameValid(false);
            loginView.isPasswordValid(false);
        } else {
            DemoModel model = new DemoModel(Name , Password);
            loginView.onLoginResult(true);
        }
    }

    @Override
    public void onLogin(String name, String password) {
        validateNameAndPassword(name , password);
    }
}