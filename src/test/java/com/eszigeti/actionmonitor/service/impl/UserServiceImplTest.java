package com.eszigeti.actionmonitor.service.impl;

import com.eszigeti.actionmonitor.model.User;
import com.eszigeti.actionmonitor.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class UserServiceImplTest {

    private static final User DEFAULT_USER = new User();
    private static final User DEFAULT_SAVED_USER = new User();
    private static final long DEFAULT_USER_ID = 1L;
    private  UserRepository userRepositoryMock;
    private UserServiceImpl underTest;

    @BeforeEach
    private void setUp() {
        userRepositoryMock = Mockito.mock(UserRepository.class);
        underTest = new UserServiceImpl(userRepositoryMock);
    }

    @Test
    public void saveUserShouldCallRepository() {
        //GIVEN
        Mockito.when(userRepositoryMock.save(DEFAULT_USER)).thenReturn(DEFAULT_SAVED_USER);
        //WHEN
        User actual = underTest.saveUser(DEFAULT_USER);
        //THEN
        Assertions.assertEquals(DEFAULT_SAVED_USER, actual);
    }

    @Test
    public void deleteUserShouldCallRepository() {
        //WHEN
        underTest.deleteById(DEFAULT_USER_ID);
        //THEN
        Mockito.verify(userRepositoryMock, Mockito.times(1)).deleteById(DEFAULT_USER_ID);
    }

    @Test
    public void getUserShouldCallRepository() {
        //GIVEN
        Mockito.when(userRepositoryMock.findById(DEFAULT_USER_ID)).thenReturn(Optional.of(DEFAULT_USER));
        //WHEN
        User actual = underTest.getUser(DEFAULT_USER_ID);
        //THEN
        Assertions.assertEquals(DEFAULT_USER, actual);
    }

}