import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        CategoriaDAO dao2 = new CategoriaDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "1- Produto | 2- Categoria | 0- Sair"
            );
        int choose = sc.nextInt();
        sc.nextLine(); // Limpa buffer
        do{
            if(choose == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch(choose){
                case 1:
                    System.out.println(
                        "1- Inserir | 2-Listar | 3- Atualizar | 4- Deletar"
                    );
                    int opcao = sc.nextInt();
                    sc.nextLine(); // Limpa buffer

                    switch (opcao) {
                        case 1:
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("Preço: ");
                            double preco = sc.nextDouble();
                            Produto p = new Produto(nome, preco);
                            dao.inserir(p);
                        break;

                        case 2: 
                            for (Produto prod : dao.listar()) {
                                System.out.println(prod.getId() + " - " + prod.getNome() + " - R$" +  prod.getPreco());
                            };
                        break;

                        case 3:
                            System.out.print("ID do produto: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Novo nome: ");
                            nome = sc.nextLine();
                            System.out.print("Novo preço: ");
                            preco = sc.nextDouble();
                            p = new Produto(nome, preco);
                            p.setId(id);
                            dao.atualizar(p);
                        break;

                        case 4:
                            System.out.print("ID do produto a deletar: ");
                            id = sc.nextInt();
                            dao.deletar(id);
                        break;

                        default:
                            System.out.println("Opção inválida!");
                        break;
                    }
                break;

                case 2:
                    System.out.println(
                        "1- Inserir | 2-Listar | 3- Atualizar | 4- Deletar"
                    );
                    int opcao2 = sc.nextInt();
                    sc.nextLine(); // Limpa buffer

                    switch (opcao2) {
                        case 1:
                            System.out.print("Nome: ");
                            String nome = sc.nextLine();
                            System.out.print("Ativo: ");
                            boolean ativo = sc.nextBoolean();
                            Categoria p = new Categoria(nome, ativo);
                            dao2.inserir(p);
                        break;

                        case 2: 
                            for (Categoria categ : dao2.listar()) {
                                System.out.println(categ.getId() + " - " + categ.getNome() + " - " +  categ.isAtivo());
                            };
                        break;

                        case 3:
                            System.out.print("ID da categoria: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Novo nome: ");
                            nome = sc.nextLine();
                            System.out.print("Novo status: ");
                            ativo = sc.nextBoolean();
                            p = new Categoria(nome, ativo);
                            p.setId(id);
                            dao2.atualizar(p);
                        break;

                        case 4:
                            System.out.print("ID da categoria a deletar: ");
                            id = sc.nextInt();
                            dao2.deletar(id);
                        break;

                        default:
                            System.out.println("Opção inválida!");
                        break;
                    }
                break;

                case 3:
                    System.out.println("Saindo...");
                break;

                default:
                    System.out.println("Opção inválida!");
                break;
            }
        } while (choose == 3);
        sc.close();
    }
}

