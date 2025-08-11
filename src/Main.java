import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //Dados de conexão
        String url = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = ""; // Substitua pela sua senha do MySql

        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            // Cria e executa uma consulta SQL
            String sql = "Select * FROM produtos";
            Statement stmt = conexao.createStatement();
            ResultSet resultado =stmt.executeQuery(sql);

            // Exibe os produtos no console
            System.out.println("Lista de Produtos");
            while(resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");

                System.out.println(id + " - " + nome + " - R$" + preco);
            }

            //fecha a conexão

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println
            ("Erro ao conectar" + e.getMessage());
        }


    }
}

