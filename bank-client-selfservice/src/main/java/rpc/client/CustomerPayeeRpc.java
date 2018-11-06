package rpc.client;

import Const.ResponseStatusType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.*;
import service.ICustomerPayeeService;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class CustomerPayeeRpc {
    private static final Logger logger = Logger.getLogger(CustomerPayeeRpc.class.getName());

    private static CustomerPayeeRpc customerPayeeRpc = null;

    public static CustomerPayeeRpc getInstance() {
        if(customerPayeeRpc == null) {
            customerPayeeRpc = new CustomerPayeeRpc();
        }
        return customerPayeeRpc;
    }

    public List<UserPayeesReply> getPayeeList(UserCustomerGetPayeesRequest userCustomerGetPayeesRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);
        logger.info(userCustomerGetPayeesRequest.getUserPk() + " is requesting to get payee list.");

        Response response = blockingStub.getPayees(userCustomerGetPayeesRequest);
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetPayeesRequest.getUserPk() + " requesting to get payee list is successful");
            return response.getUserPayeesList();
        } else {
            logger.info(userCustomerGetPayeesRequest.getUserPk() + " requesting to get payee list is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response addPayee(UserCustomerAddPayeeRequest userCustomerAddPayeeRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);
        logger.info(userCustomerAddPayeeRequest.getUserPk() + " is requesting to add payee.");

        Response response = blockingStub.addPayee(userCustomerAddPayeeRequest);
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerAddPayeeRequest.getUserPk() + " requesting to add payee is successful");
            return response;
        } else {
            logger.info(userCustomerAddPayeeRequest.getUserPk() + " requesting to add payee is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response removePayee(UserCustomerRemovePayeeRequest userCustomerRemovePayeeRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);
        logger.info(userCustomerRemovePayeeRequest.getUserPk() + " is requesting to remove.");

        Response response = blockingStub.removePayee(userCustomerRemovePayeeRequest);
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerRemovePayeeRequest.getUserPk() + " requesting to remove payee is successful");
            return response;
        } else {
            logger.info(userCustomerRemovePayeeRequest.getUserPk() + " requesting to remove payee is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

}