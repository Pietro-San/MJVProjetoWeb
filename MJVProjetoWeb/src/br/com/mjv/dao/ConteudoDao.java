package br.com.mjv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mjv.model.Conteudo;

public class ConteudoDao{
	
	BD bd = new BD();
	String men = "";
	
	//Método Visualizar
	
	public String proximoCodigo(Conteudo cont){
		if(bd.getConnection()) {
			try {
				PreparedStatement ps = bd.connection.prepareStatement("SELECT MAX(id) FROM POSTS;");
				ResultSet rs = ps.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return men;
	}
	
	//Método Incluir
	
	public String incluir(Conteudo cont){
		
		if(bd.getConnection()) {
			try {
				PreparedStatement ps = bd.connection.prepareStatement("INSERT INTO POSTS VALUES (?,?,?,?)");
				ps.setString(1, null);  //-> Desnecessário graças ao "Auto-Increment" da Primary Key
				//ps.setInt(2, cont.getUserId());
				ps.setString(2, cont.getTitle());
				ps.setString(3, cont.getBody());
				ps.executeUpdate();
				men = "Cadastro efetuado com sucesso.";
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
	
//	//Método Alterar   -> Não será necessário nesse projeto de exemplo
//	
//	public String alterar(Conteudo cont){
//		if(bd.getConnection()) {
//			try {
//				PreparedStatement ps = bd.connection.prepareStatement("UPDATE POSTS SET USER = ? WHERE ID = ?;");
//				ps.setString(1, user.getUser());
//				ps.setInt(2, user.getId());
//				ps.executeUpdate();
//				men = "Dados alterados com sucesso.";
//				ResultSet rs = ps.executeQuery();
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					bd.close();
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//			}
//		}
//		return men;
//	}
	
	//Método Excluir
	
		public String excluir(Conteudo cont){
			if(bd.getConnection()) {
				try {
					PreparedStatement ps = bd.connection.prepareStatement("DELETE FROM POSTS WHERE ID = ?;");
					ps.setString(1, Integer.toString(cont.getId()));
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
		
			public Conteudo pesquisarId(Conteudo cont){
				if(bd.getConnection()) {
					try {
						PreparedStatement ps = bd.connection.prepareStatement("SELECT FROM POSTS WHERE ID ="+cont.getId()+";");
						bd.resultSet = ps.executeQuery();
						if(bd.resultSet.next() == true) {
							cont.setId(bd.resultSet.getInt(1));
							cont.setUserId(bd.resultSet.getInt(2));
							cont.setTitle(bd.resultSet.getString(3));
							cont.setBody(bd.resultSet.getString(4));
						}else {
							cont = null;
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
				return cont;	
			}
			
		//Método Listar
			
			public List<Conteudo> listar(){
				List<Conteudo> lista = null;
				if(bd.getConnection()) {
					try {
						PreparedStatement stmt = bd.connection.prepareStatement("SELECT * FROM POSTS;");
						bd.resultSet = stmt.executeQuery();
						lista = new ArrayList<Conteudo>();
						while(bd.resultSet.next()) {
							Conteudo cont = new Conteudo();
							cont.setId(bd.resultSet.getInt(1));
							cont.setUserId(bd.resultSet.getInt(2));
							cont.setTitle(bd.resultSet.getString(3));
							cont.setBody(bd.resultSet.getString(4));
							lista.add(cont);
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
