/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsanchez.mywebtools.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pdsanchez.mywebtools.entity.Category;
import pdsanchez.mywebtools.entity.Subcategory;
import pdsanchez.mywebtools.entity.Tool;
import pdsanchez.mywebtools.model.service.contract.AuxSvc;
import pdsanchez.mywebtools.model.service.contract.ToolsSvc;

/**
 *
 * @author pdsanchez
 */
@Component
public class AuxSvcImpl implements AuxSvc {

    private static final String TAB = "\t";

    @Autowired
    private ToolsSvc toolSvc;

    @Override
    public int loadTools() {
        int total = 0;

        File file = this.getDataFile();
        List<Tool> list = getTools(file);
        for (Tool t : list) {
            toolSvc.addTool(t);
            total++;
        }

        return total;
    }

    private File getDataFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("data.tsv").getFile());
    }

    private List<Tool> getTools(File file) {
        List<Tool> list = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] reg = scanner.nextLine().split("\t");

                String category = reg[0];
                String subcategory = reg[1];
                String name = reg[2];
                String url = reg[3];
                String description = (reg.length > 4) ? reg[4] : "";

                Category c = new Category(category);
                Subcategory sc = new Subcategory(subcategory);

                Tool tool = new Tool(name, url);
                tool.setDescription(description);
                tool.setCategory(c);
                tool.setSubcategory(sc);
                list.add(tool);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
