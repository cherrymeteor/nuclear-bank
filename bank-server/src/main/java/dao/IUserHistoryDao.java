package dao;

import entity.UserHistoryEntity;

import java.util.List;

public interface IUserHistoryDao {

    void addOperationHistory(UserHistoryEntity operationHistory);

    List<UserHistoryEntity> getOperationHistoriesTodayByUserId(Long userId);

    UserHistoryEntity getLastLoginRecordByUserId(Long userId);
}