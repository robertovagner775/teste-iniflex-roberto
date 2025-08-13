package org.roberto.teste;

import org.roberto.teste.classes.Funcionario;
import org.roberto.teste.servicos.GestaoEmpresa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {


        Funcionario func1 = new Funcionario("Maria", LocalDate.parse("2000-10-10"), new BigDecimal(2009.44), "Operador");
        Funcionario func2 = new Funcionario("João", LocalDate.parse("1990-05-12"), new BigDecimal(2284.44), "Operador");
        Funcionario func3 = new Funcionario("Caio", LocalDate.parse("1961-05-02"), new BigDecimal(9836.14), "Coordenador");
        Funcionario func4 = new Funcionario("Miguel", LocalDate.parse("1988-10-14"), new BigDecimal(19119.88), "Diretor");
        Funcionario func5 = new Funcionario("Alice", LocalDate.parse("1995-01-05"), new BigDecimal(2234.68), "Recepcionista");
        Funcionario func6 = new Funcionario("Heitor", LocalDate.parse("1999-11-19"), new BigDecimal(1582.72), "Operador");
        Funcionario func7 = new Funcionario("Arthur", LocalDate.parse("2000-10-10"), new BigDecimal(4071.84), "Contador");
        Funcionario func8 = new Funcionario("Laura", LocalDate.parse("1993-03-31"), new BigDecimal(3017.45), "Gerente");
        Funcionario func9 = new Funcionario("Heloisá", LocalDate.parse("2003-05-24"), new BigDecimal(1606.85), "Eletricista");
        Funcionario func10 = new Funcionario("Helena", LocalDate.parse("1996-09-02"), new BigDecimal(2799.93), "Gerente");
        List<Funcionario> funcionarios = Arrays.asList(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10);

        funcionarios.remove(new Funcionario("João"));

        // cria o MAP por função
        Set<String> funcoes = funcionarios.stream()
                .map(f -> f.getFuncao())
                .collect(Collectors.toSet());

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcoes.stream().collect(Collectors.toMap(s -> s, s -> {
            return funcionarios.stream().filter(f -> f.getFuncao().equals(s)).toList();
        }));

        // imprime os funcionarios
        GestaoEmpresa ge = new GestaoEmpresa(funcionarios);
        ge.imprimirFuncionarios();

        // Atualizando o Sálario
        System.out.println("Novo Sálario dos funcionarios");
        ge.aumentarSalarioDosFuncionarios(10);
        ge.imprimirFuncionarios();

        // total do salario
        Double totalSalario = funcionarios.stream().mapToDouble(f -> f.getSalario().doubleValue()).sum();
        System.out.printf("Total do salario dos  funcionarios %.2f \n", totalSalario);


        // imprime os funcionarios que fazem aniversario no mes 11 12
        System.out.println("Lista dos Funcionarios que Fazem Aniversário no Mes 11 e 12");
        List<Funcionario> listaFuncionariosAniversariantes = funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 11 || f.getDataNascimento().getMonthValue() == 12)
                .toList();
        ge.imprimirFuncionarios(listaFuncionariosAniversariantes);


        // pega o funcionario mais velho
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream().max((f1, f2) -> f1.getIdade().compareTo(f2.getIdade()));
        if(funcionarioMaisVelho.isPresent()) {
            System.out.println("Funcionário mais velho é");
            System.out.println("Nome: "+ funcionarioMaisVelho.get().getNome() + " Idade: " + funcionarioMaisVelho.get().getIdade());
        }

        System.out.println("Lista dos Funcionarios em Ordem Alfabeticá");
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        ge.imprimirFuncionarios(funcionarios);

        // imprime a qtd de salário minimo
        ge.imprimeQtdSalarioMinimo();


    }
}