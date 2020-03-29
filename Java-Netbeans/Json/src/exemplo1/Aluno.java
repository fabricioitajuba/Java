/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo1;

import java.sql.Timestamp;
import json.JSONObject;

/**
 *
 * @author fabricio
 */
public class Aluno {
    
    private String Matricula;
    private String Nome;
    private Timestamp Nascimento;
    private int Idade;

    public Aluno() {
    }    
    
    //Converte de Json para Objeto
    public Aluno(JSONObject json) {
        this.Matricula = json.getString("Matricula");
        this.Nome = json.getString("Nome");
        this.Nascimento = (Timestamp) json.get("Nascimento");
        this.Idade = json.getInt("Idade");
    }    
    
    //Converte Objeto para Json
    public JSONObject toJson(){
        
        json.JSONObject json = new JSONObject();
        
        json.put("Matricula", this.Matricula);
        json.put("Nome", this.Nome);
        json.put("Nascimento", this.Nascimento);
        json.put("Idade", this.Idade);
        
        return json;
    } 
    
    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Timestamp getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Timestamp Nascimento) {
        this.Nascimento = Nascimento;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }        
}
