package dao;
import models.UserProviderDTO;
import java.util.List;

public interface IProvidersDao {

    public List<UserProviderDTO> getAllProvider();
    public Boolean insertProvider (UserProviderDTO user);
}
