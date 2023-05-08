package com.server.graph_db.query.match.path;

import java.util.ArrayList;
import java.util.List;

import com.server.graph_db.query.Result;

public class PathResult extends Result{
    List<String> columnNames;
    List<List<String>> rows;


    public PathResult(List<String> columnNames, List<String[]> rows) {
        this.columnNames = columnNames;
        this.rows = new ArrayList<>();
        for(String[] row : rows){
            List<String> newRow = new ArrayList<>();
            for(String cell : row){
                newRow.add(cell);
            }
            this.rows.add(newRow);
            
        }
        setMessage(rows.size()+" match(s) found");
    }

    public String toString(){
        return createTable(columnNames, rows)+"\n"+super.toString();
    }

  

    public static String createTable(List<String> columnNames, List<List<String>> rows) {
        // Calculate the maximum width of each column
        int[] maxColumnWidths = new int[columnNames.size()];
        for (int i = 0; i < columnNames.size(); i++) {
            maxColumnWidths[i] = columnNames.get(i).length();
        }
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                String cell = row.get(i);
                maxColumnWidths[i] = Math.max(maxColumnWidths[i], cell.length());
            }
        }
    
        // Build the table string
        StringBuilder sb = new StringBuilder();
    
        // Build the header row
        for (int i = 0; i < columnNames.size(); i++) {
            sb.append(padString(columnNames.get(i), maxColumnWidths[i])).append(" | ");
        }
        sb.append("\n");
    
        // Build the separator row
        for (int i = 0; i < columnNames.size(); i++) {
            sb.append(padString("", maxColumnWidths[i], '-')).append("-+-");
        }
        sb.append("\n");
    
        // Build the data rows
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                sb.append(padString(row.get(i), maxColumnWidths[i])).append(" | ");
            }
            sb.append("\n");
        }
    
        return sb.toString();
    }
    
    private static String padString(String s, int width) {
        return padString(s, width, ' ');
    }
    
    private static String padString(String s, int width, char padding) {
        if (s.length() >= width) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while (sb.length() < width) {
            sb.append(padding);
        }
        return sb.toString();
    }
    
}
