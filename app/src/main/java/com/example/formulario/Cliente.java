package com.example.formulario;


import android.os.Parcel;
import android.os.Parcelable;


public class Cliente implements Parcelable {
    private String nome;
    private String nota;
    private String cupom;
    private String seguimento;

    public Cliente(String nome, String seguimento, String nota, String cupom)
    {
        this.nome       = nome;
        this.nota       = nota;
        this.cupom      = cupom;
        this.seguimento = seguimento;
    }

    public String getSeguimento() {
        return seguimento;
    }
    public void setSeguimento(String seguimento) {
        this.seguimento = seguimento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nome = nota;
    }

    public String getCupom() {
        return cupom;
    }
    public void setCupom(String cupom) {
        this.nome = cupom;
    }

    protected Cliente(Parcel in) {
        nome       = in.readString();
        nota       = in.readString();
        cupom      = in.readString();
        seguimento = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(nota);
        dest.writeString(cupom);
        dest.writeString(seguimento);
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };
}