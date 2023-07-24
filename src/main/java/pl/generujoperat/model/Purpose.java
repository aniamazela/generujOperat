package pl.generujoperat.model;

public enum Purpose {
    PROJEKTOWKA{
        public String getDescription(){
            return "mapa do celów projektowych";
        }
    },
    WZNOWIENIE{
        public String getDescription(){
            return "wznowienie znaków granicznych";
        }
    },
    WYZNACZENIE{
        public String getDescription(){
            return "wyznaczenie punktów granicznych";
        }
    },

    USTALENIE{
        public String getDescription(){
            return "ustalenie przebiegu granic działek ewidencyjnych";
        }
    },

    PODZIAL{
        public String getDescription(){
            return "mapa z projektem podziału nieruchomości";
        }
    },

    PODZIAL_ROLNY{
        public String getDescription(){
            return "mapa z projektem podziału nieruchomości rolnej";
        }
    },

    PRAWNA{
        public String getDescription(){
            return "inna mapa do celów prawnych";
        }
    },

    INWENTARYZACJA{
        public String getDescription(){
            return "inwentaryzacja budynku";
        }
    },

    INNY {
        public String getDescription(){
            return "inny cel";
        }
    }
}
