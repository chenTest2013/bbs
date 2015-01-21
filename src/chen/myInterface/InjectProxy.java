/**
 * 
 */
package chen.myInterface;

/**
 * @author john
 *此接口用于让
 *实现该接口的Bean将自身的代理对象注入自身属性当中
 *自动注入用自定义的Bean后处理器执行！
 */
public interface InjectProxy {
public void setSelfProxy(InjectProxy obj);

public String aa(String str) ;
public String ab(String str) ;
}
