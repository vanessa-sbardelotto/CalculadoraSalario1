import java.util.Scanner;
public class CaluloSalario {
    public static void main(String[]args){
        Scanner valor = new Scanner(System.in);
        System.out.println("Informe o salário bruto R$: ");
        double salarioBruto = valor.nextDouble();

        //calcular do INSS
        double inss = calcularINSS(salarioBruto);
        //base calculo do IRPF
        double baseIR = salarioBruto - inss;
        //calculo do IRPF
        double irpf = calcularIRPF(baseIR);
        //salario liquido
        double salarioLiquido = salarioBruto - inss - irpf;
        //valor por hora
        double valorHoraBruto = salarioBruto / 220;
        double valorHoraLiquido = salarioLiquido / 220;
        //Saidas resultados

        System.out.println("\n====Demonstrativo de Pagamento====");
        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("Desconto do INSS: R$ " + inss);
        System.out.println("Desconto IRPF: R$ " + irpf);
        System.out.println("Salario Liquido: R$ " + salarioLiquido);
        System.out.println("--------------------------");
        System.out.println("Valor da Hora 'bruto': R$ " + valorHoraBruto);
        System.out.println("Valor da Hora 'Liquido': R$ " + valorHoraLiquido);
        valor.close();
    }
    public static double calcularINSS(double salario) {
        double inss = 0.0;
        if (salario <= 1412.00) {
            inss = salario * 0.075;
        } else if (salario <= 2666.68) {
            inss = (1412.00 * 0.075) + ((salario - 1412.00) * 0.09);
        } else if (salario <= 4000.03) {
            inss = (1412.00 * 0.075 + ((2666.68 - 1412.00) * 0.09) + (salario - 2666.68)
                    * 0.12);
        } else if (salario <= 7786.02) {
            inss = (1412.00 * 0.075) + ((2666.68 - 1412.00) * 0.09) + ((4000.03 - 2666.68)
                    * 0.12) + ((salario - 4000.03) * 0.14);
        } else {
            inss = 908.85;
        }
        return inss;
    }
    public static double calcularIRPF(double baseCalculo){
        double ir = 0.0;
        if (baseCalculo <= 2112.00){
            ir = 0.0;
        }else if (baseCalculo <= 28826.65){
            ir = (baseCalculo * 0.075) - 158.40;
        }else if (baseCalculo <= 3751.05){
            ir = (baseCalculo * 0.15) - 370.40;
        }else if (baseCalculo <= 4664.68){
            ir = (baseCalculo * 0.225) - 651.73;
        }else{
            ir = (baseCalculo * 0.275) - 884.96;
        }
        return Math.max(ir,0);
    }
}