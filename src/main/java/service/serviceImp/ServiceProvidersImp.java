package service.serviceImp;

import dao.daoImp.ProvidersImp;
import models.UserProviderDTO;
import service.IServiceProviders;

import java.util.List;

public class ServiceProvidersImp implements IServiceProviders {
    private ProvidersImp providersImp = new ProvidersImp();

    @Override
    public List<UserProviderDTO> getAllUserProviders() {
        return providersImp.getAllProvider();
    }

    @Override
    public Boolean insertUserProvider(UserProviderDTO user) {
        return  providersImp.insertProvider(user);
    }
}
