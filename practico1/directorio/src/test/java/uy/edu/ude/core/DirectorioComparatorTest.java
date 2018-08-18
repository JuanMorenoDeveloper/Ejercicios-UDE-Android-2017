package uy.edu.ude.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.ude.data.DataSource;

import java.util.List;

public class DirectorioComparatorTest {
    private DirectorioComparator directorioComparator;
    private DataSource dataSource;
    @Before
    public void init(){
        directorioComparator=new DirectorioComparator();
        dataSource=new DataSource(10);
    }
    @Test
    public void shouldGetFoundStringAndReturnTrue(){
        List<String> dataList=dataSource.getData();
        String stringTest=dataList.get(0);
        Assert.assertEquals(true,directorioComparator.isStringInList(stringTest,dataList));
    }
    @Test
    public void shouldNotGetFoundStringAndReturnFalse(){
        List<String> dataList=dataSource.getData();
        String stringTest="";
        Assert.assertEquals(false,directorioComparator.isStringInList(stringTest,dataList));
    }
}
