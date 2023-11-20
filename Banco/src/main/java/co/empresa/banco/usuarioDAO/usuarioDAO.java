package co.empresa.banco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.banco.modelo.Usuario;
import co.empresa.banco.util.Conexion;

public class UsuarioDao {

    private Conexion conexion;
    private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?);";
    private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
    private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre=?, email=?, pais=? WHERE id = ?;";
    private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
   

    public UsuarioDao() {
        this.conexion = Conexion.getConexion();
    }

    public void insert(Usuario usuario) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getPais());
            conexion.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
            preparedStatement.setLong(1, id);
            conexion.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Usuario usuario) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getPais());
            preparedStatement.setLong(4, usuario.getId());
            conexion.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> selectAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String pais = rs.getString("pais");
                usuarios.add(new Usuario(id, nombre, email, pais));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario select(long id) {
        Usuario usuario = null;
        try {
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String pais = rs.getString("pais");
                usuario = new Usuario(id, nombre, email, pais);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}

