package org.roberto.teste.classes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(String nome) {
        super(nome, null);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Integer getQtdSalarioMinimo() {
       Double valor = this.salario.doubleValue() / 1212.00;
       return valor.intValue();
    }

    public void atualizarSalario(Integer valorPorcentagem) {
       Double aumento =  (this.salario.doubleValue() / 100) * valorPorcentagem.doubleValue();
       this.setSalario(this.salario.add(BigDecimal.valueOf(aumento)));
    }

    public Integer getIdade() {
        return LocalDate.now().getYear() - getDataNascimento().getYear();
    }

    public String getSalarioFormatado() {
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        return formato.format(this.getSalario());
    }

    public String getDataNascimentoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.getDataNascimento().format(formatter);
    }
}
