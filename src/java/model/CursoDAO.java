/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class CursoDAO {

    Connection conn;

    /**
     * Método Construtor sempre que criar um objeto, chama esse método
     */
    public CursoDAO() {
        //conectar com o banco de dados
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //conectar efetivamente com o SGBD
            //montar comando SQL para inserçao
            String host = "jdbc:mysql://localhost/alfajava";
            String user = "root";
            String pass = "";
            //entao, criar comando e executar
            this.conn = DriverManager.getConnection(host, user, pass);
        } catch (Exception e) {
            this.conn = null;
        }
    }

    /**
     * @Return List<Curso>
     */
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<Curso>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from cursos";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                Curso obj = new Curso();
                obj.setCodigo(rset.getLong("codigo"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setValor(rset.getDouble("valor"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }catch(Exception e){
            e.printStackTrace();
            lista = null;
        }

        return lista;
    }
    
    /**
     * método para ser usado como JavaBean getCurso()
     */
    public List<Curso> getCursos(){
        return listar();
    }
    
    /**
     * @Return Curso
     */
    public Curso buscar(String filtro) {
        //List<Curso> lista = new ArrayList<Curso>();
        Curso obj = new Curso();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from cursos where "+filtro;
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                //Curso obj = new Curso();
                obj.setCodigo(rset.getLong("codigo"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setValor(rset.getDouble("valor"));
                //adiciona o obj em uma lista
                //lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }catch(Exception e){
            e.printStackTrace();
            obj = null;
        }

        return obj;
    }

    /**
     * método para cadastrar um novo curso
     *
     * @param obj
     */
    public int inserir(Curso obj) {
        int res = 0;
        String nom = obj.getNome();
        String des = obj.getDescricao();
        Double val = obj.getValor();
        String sql = "insert into cursos (nome, descricao, valor) values (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setDouble(3, val);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }

    /**
     * método para atualizar um novo específico
     *
     * @param obj
     */
    public int atualizar(Curso obj) {
        int res = 0;
        Long cod = obj.getCodigo();
        String nom = obj.getNome();
        String des = obj.getDescricao();
        Double val = obj.getValor();
        String sql = "update cursos set nome=?, descricao=?, valor=? where codigo=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setDouble(3, val);
            stmt.setLong(4, cod);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }

    /**
     * método para excluir um novo específico
     *
     * @param obj
     */
    public int excluir(Curso obj) {
        int res = 0;
        Long cod = obj.getCodigo();
        String sql = "delete from cursos where codigo=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, cod);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }
}
