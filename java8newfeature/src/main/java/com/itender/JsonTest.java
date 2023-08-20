package com.itender;

import com.google.common.base.CharMatcher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itender.newfeature.WarnResultConditionEntity;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author itender
 * @date 2022/8/26 12:37
 * @desc
 */
public class JsonTest {
    private static Gson gson = new GsonBuilder().serializeNulls().create();


    public static void main(String[] args) throws IOException {
        String filters = "D:\\Users\\Desktop\\new 3.txt";

        RandomAccessFile f = new RandomAccessFile(new File(filters), "r");
        String warnSearchConditionStr = new String(f.readLine().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        f.close();
        System.out.println(warnSearchConditionStr);
        // Type type = new TypeToken<List<WarnResultFilterEntity>>() {
        // }.getType();
        // warnSearchConditionStr = warnSearchConditionStr.replace("\t", "");
        // warnSearchConditionStr = warnSearchConditionStr.replaceAll("\\\\", "").trim();
        String result = StringEscapeUtils.escapeJson(warnSearchConditionStr);
        System.out.println(result);
        WarnResultConditionEntity warnResultCondition = gson.fromJson(result, (Type) Map.class);
        System.out.println(warnResultCondition.toString());
        String string = " ";


        //使用replaceAll
        // String text = "Our line rackets \rthe encouraged symmetry.\n";
        // String result = text.replaceAll("\n", "").replaceAll("\r", "");
        // System.out.println(result);
        // String randomSentence = "The backed valley manufactures \r"
        //         + "a politician above \n" + "a scratched body.";
        // //google guava
        // result = CharMatcher.breakingWhitespace().removeFrom(randomSentence);
        // System.out.println(result);
        // //apache commons
        // String randomSentence2 = "The pocket reflects "
        //         + "over an intimate. \r";
        // result = StringUtils.chomp(randomSentence2);
        // System.out.println(result);
    }
}
