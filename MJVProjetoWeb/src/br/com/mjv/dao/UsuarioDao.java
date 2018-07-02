package br.com.mjv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mjv.model.Conteudo;
import br.com.mjv.model.Usuario;

public class UsuarioDao{
	
	BD bd = new BD();
	String men = "";
	
	//Método Visualizar
	
	public String proximoCodigo(Usuario user){
		if(bd.getConnection()) {
			try {
				PreparedStatement ps = bd.connection.prepareStatement("SELECT MAX(id) FROM USERS;");
				ResultSet rs = ps.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return men;
	}
	
	//Método Incluir
	
	public String incluir(Usuario user){
		if(bd.getConnection()) {
			try {
				PreparedStatement ps = bd.connection.prepareStatement("INSERT INTO USERS VALUES (?,?);");
				ps.setString(1, null);  //-> Desnecessário graças ao "Auto-Increment" da Primary Key
				ps.setString(2, user.getUser());
				ps.executeUpdate();
				men = "Cadastro de Usuário efetuado com sucesso.";		

				Conteudo cont = new Conteudo();
				ConteudoDao contDao = new ConteudoDao();

			PreparedStatement ps2 = bd.connection.prepareStatement("SELECT ID FROM USERS WHERE USER = '"+user.getUser()+"'");
			bd.resultSet = ps2.executeQuery();
			 if(bd.resultSet.next() ==true) { 
				 cont.setUserId(Integer.parseInt(bd.resultSet.getString(1)));		   					   
			   }
			 PreparedStatement ps3 = bd.connection.prepareStatement("INSERT INTO POSTS VALUES (?,?,?,?)");
			 	ps3.setString(1, null);  //-> Desnecessário graças ao "Auto-Increment" da Primary Key
				ps3.setInt(2, cont.getUserId());
				ps.setString(3, cont.getTitle());
				ps.setString(4, cont.getBody());
				ps.executeUpdate();
				men = "Cadastro efetuado com sucesso.";		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				bd.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}
		return men;
	}
	//Método Alterar
	
	public String alterar(Usuario user){
		if(bd.getConnection()) {
			try {
				PreparedStatement ps = bd.connection.prepareStatement("UPDATE USERS SET USER = ? WHERE ID = ?;");
				ps.setString(1, user.getUser());
				ps.setInt(2, user.getId());
				ps.executeUpdate();
				men = "Dados alterados com sucesso.";
				ResultSet rs = ps.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					bd.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return men;
	}
	
	//Método Excluir
	
		public String excluir(Usuario user){
			if(bd.getConnection()) {
				try {
					PreparedStatement ps = bd.connection.prepareStatement("DELETE FROM USERS WHERE ID = ?;");
					ps.setString(1, Integer.toString(user.getId()));
					ps.executeUpdate();
					men = "Dados removidos com sucesso.";
					ResultSet rs = ps.executeQuery();
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						bd.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			return men;	
		}
		//Método Pesquisar ID
		
			public Usuario pesquisarId(Usuario user){
				if(bd.getConnection()) {
					try {
						PreparedStatement ps = bd.connection.prepareStatement("SELECT FROM USERS WHERE ID ="+user.getId()+";");
						bd.resultSet = ps.executeQuery();
						if(bd.resultSet.next() == true) {
							user.setId(bd.resultSet.getInt(1));
							user.setUser(bd.resultSet.getString(2));
						}else {
							user = null;
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							bd.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				return user;	
			}
			
		//Método Listar
			
			public List<Usuario> listar(){
				List<Usuario> lista = null;
				if(bd.getConnection()) {
					try {
						PreparedStatement stmt = bd.connection.prepareStatement("SELECT * FROM USER;");
						bd.resultSet = stmt.executeQuery();
						lista = new ArrayList<Usuario>();
						while(bd.resultSet.next()) {
							Usuario user = new Usuario();
							user.setId(bd.resultSet.getInt(1));
							user.setUser(bd.resultSet.getString(2));
							lista.add(user);
						}
						}catch(SQLException e){
							e.printStackTrace();
						}finally {
						try {
							bd.close();
						}catch(Exception e){
							e.printStackTrace();
						}
						}
				}
				return lista;
			}
		
		
	
}
