package com.una.serVices.service;

import com.una.serVices.data.User;

public interface ILoginService {

    public User login(User user);

    public User getUserDb(User user);

}
