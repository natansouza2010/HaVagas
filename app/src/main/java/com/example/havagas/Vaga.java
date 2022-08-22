package com.example.havagas;

public class Vaga {
    private String nome;
    private String email;
    private String telefone;
    private String celular;
    private String tipoTelefone;
    private String sexo;

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    private String dataNascimento;
    private String formacao;
    private String anoFormatura;
    private String instituicao;
    private String tituloDeMonografia;
    private String orientador;
    private String vagasDeInteresse;

    public Vaga(){

    }

    public Vaga(String nome, String email, String telefone, String celular, String sexo, String dataNascimento, String formacao, String anoFormatura, String instituicao, String tituloDeMonografia, String orientador, String vagasDeInteresse) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.anoFormatura = anoFormatura;
        this.instituicao = instituicao;
        this.tituloDeMonografia = tituloDeMonografia;
        this.orientador = orientador;
        this.vagasDeInteresse = vagasDeInteresse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getAnoFormatura() {
        return anoFormatura;
    }

    public void setAnoFormatura(String anoFormatura) {
        this.anoFormatura = anoFormatura;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloDeMonografia() {
        return tituloDeMonografia;
    }

    public void setTituloDeMonografia(String tituloDeMonografia) {
        this.tituloDeMonografia = tituloDeMonografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getVagasDeInteresse() {
        return vagasDeInteresse;
    }

    public void setVagasDeInteresse(String vagasDeInteresse) {
        this.vagasDeInteresse = vagasDeInteresse;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", formacao='" + formacao + '\'' +
                ", anoFormatura='" + anoFormatura + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", tituloDeMonografia='" + tituloDeMonografia + '\'' +
                ", orientador='" + orientador + '\'' +
                ", vagasDeInteresse='" + vagasDeInteresse + '\'' +
                '}';
    }
}
