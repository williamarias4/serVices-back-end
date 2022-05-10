package com.una.serVices.service;

import com.una.serVices.data.User;

public interface ILoginService {

    User login(User user);

    User getUserDb(User user);

}
