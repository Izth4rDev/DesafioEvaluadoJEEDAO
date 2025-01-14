package dao.daoImp;
import connections.MysqlConnection;
import dao.IProvidersDao;
import models.UserProviderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvidersImp implements IProvidersDao{
    private static final String SELECT_ALL_USERS = "SELECT name, rut, address, mail, phone_number, contact, contact_number FROM providers";
    private static final String INSERT_USER = "INSERT INTO providers(name, rut, address, mail, phone_number, contact, contact_number) VALUES(?,?,?,?,?,?,?)";

    @Override
    public List<UserProviderDTO> getAllProvider() {
        List<UserProviderDTO> providers = new ArrayList<UserProviderDTO>();
        try(Connection connection = MysqlConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                UserProviderDTO user = new UserProviderDTO();
                user.setName(res.getString("name"));
                user.setRut(res.getString("rut"));
                user.setAddress(res.getString("address"));
                user.setMail(res.getString("mail"));
                user.setPhoneNumber(res.getString("phone_number"));
                user.setContact(res.getString("contact"));
                user.setContactNumber(res.getString("contact_number"));
                providers.add(user);
            }
        }catch(SQLException e){
          throw new RuntimeException(e);
        }
        return providers;
    }

    @Override
    public Boolean insertProvider(UserProviderDTO user) {

        try(Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getRut());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.setString(7, user.getContactNumber());

            int rowInserted =  preparedStatement.executeUpdate();
            if(rowInserted > 0){
                return true;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return false;
    }
}
