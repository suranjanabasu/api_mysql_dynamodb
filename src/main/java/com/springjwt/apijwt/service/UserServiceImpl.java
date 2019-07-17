package com.springjwt.apijwt.service;


import com.springjwt.apijwt.rds_entities.User;
import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    @Override
    public UserInfo retrieveAuthUserDetails(String code) {

        //todo: Add the authentication part here

        //Retrieve the oauth2 token



        //Retrieve the user details and set the authentication

//        UsernamePasswordAuthenticationToken authReq =
//                new UsernamePasswordAuthenticationToken("test", "pwd");
//        //Authentication auth = authManager.authenticate(authReq);
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(authReq);
//        HttpSession session = request.getSession(true);
//        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
        //todo: This is a dummy user for now
        return createDummyUserInfo();
    }

    /**
     * This should be an upsert operation
     * $user = User::firstOrNew(
     *             ['uid' => $userInfo['uid']],
     *             [
     *                 'firstname' => $userInfo['firstname'],
     *                 'lastname' => $userInfo['lastname'],
     *                 'email' => $userInfo['email'],
     *                 'external_id' => Uuid::uuid4()->toString()
     *             ]
     *         );
     *
     *         $userInfo['access_token'] = $this->allocate($user);
     *
     *         $user->access_token = $userInfo['access_token'];
     *         $user->access_token_expires_at = date("Y-m-d H:i:s", time() + 3600);
     *         $user->save();
     * @return
     */
//todo: This actually will come from sso
    private UserInfo createDummyUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("test@gmail.com");
        userInfo.setFirstname("FName");
        userInfo.setLastname("Lname");
        userInfo.setMageId("MAGE001");

        return userInfo;
    }

    @Override
    public User retrieveOrCreateUser(UserInfo userInfo) {

        //Retrieve the User details from MYSQL using the mageId if present
        User userToFind = userToFind(userInfo);
        userToFind.setUid(userInfo.getMageId());
//        Example<User> userToFindExample = Example.of(userToFind);
//
//        //If not present, create the User
//        User user = userRepository.findOne(userToFindExample).orElse(null);

        User user = userRepository.findByUid(userInfo.getMageId());
        //Create the user
        if (user == null) {
            //todo: Generate the UUID etc
            userToFind.setExternalId(UUID.randomUUID().toString());
            Calendar accessTokenExpiry = Calendar.getInstance();
            accessTokenExpiry.add(Calendar.MONTH, 1);
            userToFind.setAccessTokenExpiresAt(dateFormat.format(accessTokenExpiry.getTime()));
            user = userRepository.save(userToFind);
        }

        //todo: Set the user in session- when integrating with React
//
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(authReq);
//        HttpSession session = request.getSession(true);
//        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);

        return user;
    }

    /**
     * Returns the userId created
     * @param userInfo
     * @return
     */
    private User userToFind(UserInfo userInfo) {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userInfo);
        } catch (IllegalAccessException  | InvocationTargetException e) {
            log.warn("There was an error while copying properties "+ e.toString());
        }

        return user;


    }
}
