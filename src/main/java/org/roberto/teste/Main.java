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
       // 3 – Deve conter uma classe Principal para executar as seguintes ações:
        //  3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
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

        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.remove(new Funcionario("João"));

        // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        //• informação de data deve ser exibido no formato dd/mm/aaaa;
        //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        GestaoEmpresa ge = new GestaoEmpresa(funcionarios);
        ge.imprimirFuncionarios();

        //  3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        System.out.println("Novo Salário dos funcionários");
        ge.aumentarSalarioDosFuncionarios(10);
        ge.imprimirFuncionarios();

        //  3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Set<String> funcoes = funcionarios.stream()
                .map(f -> f.getFuncao())
                .collect(Collectors.toSet());

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcoes.stream().collect(Collectors.toMap(s -> s, s -> {
            return funcionarios.stream().filter(f -> f.getFuncao().equals(s)).toList();
        }));

        // 3.6 – Imprimir os funcionários, agrupados por função.
        // NÃO CONSEGUI IMPRIMIR DE UMA FORMA INTERESSANTE DIFERENTE DOS DEMAIS

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("Lista dos Funcionarios que Fazem Aniversário no Mes 11 e 12");
        List<Funcionario> listaFuncionariosAniversariantes = funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 11 || f.getDataNascimento().getMonthValue() == 12)
                .toList();
        ge.imprimirFuncionarios(listaFuncionariosAniversariantes);

        //  3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream().max((f1, f2) -> f1.getIdade().compareTo(f2.getIdade()));
        if(funcionarioMaisVelho.isPresent()) {
            System.out.println("Funcionário mais velho é");
            System.out.println("Nome: "+ funcionarioMaisVelho.get().getNome() + " Idade: " + funcionarioMaisVelho.get().getIdade());
        }
        System.out.println("==================================================================================");
        //   3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("|                  Lista dos Funcionários em Ordem Alfabeticá                     |");
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        ge.imprimirFuncionarios(funcionarios);

        // total do salario -  3.11 – Imprimir o total dos salários dos funcionários.
        System.out.printf("Salário total dos funcionários %s \n", ge.getSalarioTotalDosFuncionarios());

        // 3.12 Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        ge.imprimeQtdSalarioMinimo();


    }
}
