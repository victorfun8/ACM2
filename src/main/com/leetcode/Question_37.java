package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author fangji
 *
 * 题目：https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * 解题思路：
 *
 * 参考资料：
 */
public class Question_37 {

    //初始化历史操作记录
    Stack<String> his = new Stack<String>();

    public void solveSudoku(Stack his, char[][] board) {
        //1. 初始化
        List[] hengList = new List[9];
        List[] shuList = new List[9];
        List[] geziList = new List[9];
        for (int i = 0; i < 9; i++) {
            hengList[i] = new ArrayList<Character>();
            shuList[i] = new ArrayList<Character>();
            geziList[i] = new ArrayList<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    hengList[i].add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    shuList[i].add(board[j][i]);
                }

                int indexX = i / 3 * 3 + j / 3;
                if (board[i][j] != '.') {
                    geziList[indexX].add(board[i][j]);
                }
            }
        }
        //1. 初始化完成

        //2. 初始化
        Map<String, List> m = new HashMap<String, List>();
        //2. 初始化完成

        //3. 开始
        boolean isChange = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    List<Character> ij = initList();
                    ij.removeAll(hengList[i]);
                    ij.removeAll(shuList[j]);
                    ij.removeAll(geziList[i / 3 * 3 + j / 3]);
                    if (ij.size() == 0) {
                        String s = (String) his.pop();
                    } else if (ij.size() == 1) {
                        board[i][j] = (Character) ij.get(0);
                        isChange = true;
                        continue;
                    }
                    m.put(i + "" + j, ij);
                }
            }
        }

        if (!isChange) {
            m.clear();
            solveSudoku(his, board);
        } else {
            String minKey = "";
            int minLen = Integer.MAX_VALUE;

            Iterator<Map.Entry<String, List>> it = m.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List> es = it.next();
                if (es.getValue().size() < minLen) {
                    minKey = es.getKey();
                    minLen = es.getValue().size();
                }
            }

            char temp = (Character) m.get(minKey).get(0);


        }
    }

    private List<Character> initList() {
        List<Character> ij = new ArrayList<Character>();
        ij.add('0');
        ij.add('1');
        ij.add('2');
        ij.add('3');
        ij.add('4');
        ij.add('5');
        ij.add('6');
        ij.add('7');
        ij.add('8');
        ij.add('9');
        return ij;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//		System.out.println("solveSudoku = " + new Question_37().solveSudoku(board));
    }

}
