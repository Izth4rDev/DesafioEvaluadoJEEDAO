package service;

import models.UserProviderDTO;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.util.List;

public interface IServiceProviders {
    public List<UserProviderDTO> getAllUserProviders();
    public Boolean insertUserProvider(UserProviderDTO user);
}
