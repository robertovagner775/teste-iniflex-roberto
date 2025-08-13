package org.roberto.teste.servicos.impl;

import org.roberto.teste.classes.Funcionario;

import java.util.List;

public interface EmpresaImpl {

    public void imprimeQtdSalarioMinimo();

    public void imprimirFuncionarios();

    public void imprimirFuncionarios(List<Funcionario> funcionarios);

    public void aumentarSalarioDosFuncionarios(Integer valorPorcentagem);

    public String getSalarioTotalDosFuncionarios();
}
