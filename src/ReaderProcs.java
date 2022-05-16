
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

public class ReaderProcs {

    public static ReaderInfo readFile(String filename, Process proc, String[] memory, int posicaoMemoria) {
        String pathToFile = Paths.get(filename).toString();
        int numLine = posicaoMemoria;
        String[] scheduler = memory;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (line.contains(".")) {
                        switch (line) {
                            case ".code":
                                proc.setProgramStart(numLine);
                                proc.setPc(numLine);
                            case ".endcode":
                                proc.setProgramEnd(numLine - 1);
                            case ".data":
                                proc.setVarStart(numLine);
                            case ".enddata":
                                proc.setVarEnd(numLine);
                        }
                    } else {
                        scheduler[numLine] = line.trim();
                        numLine++;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("Nao foi possivel ler o numero de pares do arquivo: " + pathToFile);
        } catch (Exception ex) {
            System.err.println("Nao foi possivel ler string do arquivo: " + pathToFile);
        }

        return new ReaderInfo(scheduler, numLine);
    }

}