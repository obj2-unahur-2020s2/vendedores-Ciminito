class CentroDeDistribucion {
    var property ciudad
    val vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor : Vendedor){
        if (not vendedores.contains(vendedor)){
            vendedores.add(vendedor)
        }
        else{
            self.error("El vendedor ya esta registrado en el centro")
        }
    }
    fun vendedorEstrella(){
        return vendedores.max({v => v.puntajePorCertificaciones()})
    }
    fun puedeCubrir(ciudad : Ciudad){
        return vendedores.any {v => v.puedeTrabajarEn(ciudad)}
    }
    fun vendedoresGenericos(){
        return vendedores.filter{v => v.esGenerico()}
    }
    fun esRobusto(){
        return vendedores.count{v => v.esFirme()} + >= 3
    }
    fun repartirCertificacion(certificacion : Certificacion){
        vendedores.forEach {v => v.recibirCertificacion(certificacion)}
    }


}