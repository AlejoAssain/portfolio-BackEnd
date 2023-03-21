package com.alejoassain.portfolioargprogbe.auth.service;

import com.alejoassain.portfolioargprogbe.auth.request.AuthenticationRequest;
import com.alejoassain.portfolioargprogbe.auth.request.RegisterRequest;
import com.alejoassain.portfolioargprogbe.auth.response.AuthenticationResponse;

public interface IAuthenticationService {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
