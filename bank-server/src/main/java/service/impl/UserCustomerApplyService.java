package service.impl;

import dao.impl.UserApplyDao;
import dao.impl.UserDao;
import entity.UserApplyArchiveEntity;
import entity.UserEntity;
import service.IUserCustomerApplyService;

import java.sql.Timestamp;
import java.util.Date;

public class UserCustomerApplyService implements IUserCustomerApplyService {
    private static UserCustomerApplyService userCustomerApplyService = null;
    private UserApplyDao userApplyDao = UserApplyDao.getInstance();
    private UserDao userDao = UserDao.getInstance();

    public static UserCustomerApplyService getInstance() {
        if(userCustomerApplyService == null) {
            return new UserCustomerApplyService();
        }
        return userCustomerApplyService;
    }
    @Override
    public void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                            Timestamp birthDate, int gender, String address, String email, String phone) throws Exception {
        try {
            // basic info
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setRemark("pending"); // change the attributes of this in the db
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw new Exception("Fail to apply a personal current account");
        }
    }

    @Override
    public void requestStudentAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType, Timestamp birthDate, int gender,
                                           String address, String email, String phone,
                                           Timestamp graduateDate, String studentId, String university) throws Exception {
        try{
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setRemark("pending"); // change the attributes of this in the db
            // student info
            UserApplyArchiveEntity.setGraduateDate(graduateDate);
            UserApplyArchiveEntity.setStudentId(studentId);
            UserApplyArchiveEntity.setUniversity(university);

            userApplyDao.requestAccountApply(UserApplyArchiveEntity);

        } catch (Exception e) {
            throw new Exception("Fail to apply a student current account");
        }
    }

    @Override
    public void requestYoungSaverAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType, Timestamp birthDate, int gender, String address, String email, String phone, long parentUserId, String parentFirstName, String parentLastName) throws Exception {
        try{
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserEntity UserEntity = new UserEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setRemark("pending"); // change the attributes of this in the db
            // young saver info
            UserApplyArchiveEntity.setParentUserId(parentUserId);
            UserApplyArchiveEntity.setParentFirstName(parentFirstName);
            UserApplyArchiveEntity.setParentLastName(parentLastName);

            // check parent info
            UserEntity.setUserId(parentUserId);
            UserEntity.setFirstName(parentFirstName);
            UserEntity.setLastName(parentLastName);
            UserEntity result = userDao.selectUserByIdAndName(parentUserId, parentFirstName, parentLastName);
            if(result == null) {
                throw new Exception("parent info does not exist!");
            }

            userApplyDao.requestAccountApply(UserApplyArchiveEntity);


        } catch (Exception e) {
            throw new Exception("Fail to apply a young saver account");
        }
    }

    @Override
    public void requestGoldenAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                            Timestamp birthDate, int gender, String address, String email, String phone) throws Exception {
        try {
            // basic info
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setRemark("pending"); // change the attributes of this in the db
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw new Exception("Fail to apply a golden current account");
        }
    }

    @Override
    public void checkExistingUserBeforeApply(long userId, String firstName, String lastName) throws Exception {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(userId);
            userEntity.setFirstName(firstName);
            userEntity.setLastName(lastName);

            UserEntity result = userDao.selectUserByIdAndName(userId, firstName, lastName);

            if(result == null) {
                throw new Exception("User Info not exist");
            }

        } catch (Exception E) {
            throw new Exception("Fail to validate the user info");
        }
    }
}
