package com.una.serVices.service;

import com.una.serVices.data.User;

public interface ILoginService {

    public boolean login(User user);

    public User getUserDb(User user);

}
