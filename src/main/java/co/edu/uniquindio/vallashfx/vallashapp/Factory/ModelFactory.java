package co.edu.uniquindio.vallashfx.vallashapp.Factory;


public class ModelFactory {

    public static ModelFactory modelFactory;

    public ModelFactory() {

    }


    public static ModelFactory getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactory();

        }return modelFactory;
    }

}
