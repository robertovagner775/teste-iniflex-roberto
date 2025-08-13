package org.roberto.teste.servicos;

import org.roberto.teste.classes.Funcionario;
import org.roberto.teste.servicos.impl.EmpresaImpl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GestaoEmpresa implements EmpresaImpl {

    private List<Funcionario> funcionarios;

    public GestaoEmpresa(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public void imprimeQtdSalarioMinimo() {
        System.out.println("============================================================");
        System.out.println("               Salário Mínimo dos Funcionários         ");
        System.out.println("============================================================");
        Map<Funcionario, Integer> qtdSalarioFuncionario =  this.funcionarios.stream()
                .collect(Collectors.toMap(f1 -> f1, f2 ->  f2.getQtdSalarioMinimo()));
        System.out.println("|  Nome           | Salario          | Qtd Salarios Minimos |");
        qtdSalarioFuncionario.forEach((f1, s1 ) -> {
            System.out.printf("%10s %15s %15s \n", f1.getNome(), f1.getSalarioFormatado(), s1);
        });
        System.out.println("==============================================================");
    }
    @Override
    public void imprimirFuncionarios() {
        System.out.println("==================================================================================");
        System.out.println("| Nome          | Data Nascimento          | Salário          | Função           |");
        System.out.println("==================================================================================");
        for (Funcionario func : this.funcionarios) {
            System.out.printf("%-15s %-25s %-20s %10s \n", func.getNome(), func.getDataNascimentoFormatada(), func.getSalarioFormatado(), func.getFuncao());
        }
        System.out.println("==============================================================");
    }

    @Override
    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("==================================================================================");
        System.out.println("| Nome          | Data Nascimento          | Sálario          | Função           |");
        System.out.println("==================================================================================");
        for (Funcionario func : funcionarios) {
            System.out.printf("%-15s %-25s %-20s %10s \n", func.getNome(), func.getDataNascimentoFormatada(), func.getSalarioFormatado(), func.getFuncao());
        }
        System.out.println("===================================================================================");
    }

    @Override
    public void aumentarSalarioDosFuncionarios(Integer valorPorcentagem) {
        this.funcionarios.forEach(f -> f.atualizarSalario(valorPorcentagem));
    }

    @Override
    public String getSalarioTotalDosFuncionarios() {
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        Double total = funcionarios.stream().mapToDouble(f -> f.getSalario().doubleValue()).sum();
        return formato.format(BigDecimal.valueOf(total));
    }
}
