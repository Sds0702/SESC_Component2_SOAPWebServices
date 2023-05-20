package com.users.soap;

import io.spring.guides.gs_producing_web_service.GetUsersRequest;
import io.spring.guides.gs_producing_web_service.GetUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI="http://spring.io/guides/gs_producing_web_service";
    private UserRepository userRepository;
    @Autowired
    public UserEndpoint(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUsersResponse getUser(@RequestPayload GetUsersRequest request){
        GetUsersResponse response= new GetUsersResponse();
        response.setUsers(userRepository.findUser(request.getId()));
        return response;
    }
}
