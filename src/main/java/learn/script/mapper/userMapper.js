/**
 * Created by flysLi on 2018/12/17.
 */
var sql = "select * from user where 1=1 ";

function selectAll(map){
    if(map.name!=null){
        sql+=" and name='"+map.name+"'"
    }
    if(map.name!=null){
        sql+=" and age='"+map.age+"'"
    }
    if(map.name!=null){
        sql+=" and address='"+map.address+"'"
    }
    if(map.name!=null){
        sql+=" and bird='"+map.bird+"'"
    }
    return sql;
}

function showName(name) {
    return "SELECT * FROM USER WHERE NAME='"+name+"';";
}