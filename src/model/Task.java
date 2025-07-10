package model;

public class Task {
    
    private String descricao;

    public Task() {
    }

    public Task(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "Tarefa: " + getDescricao();
    }

}