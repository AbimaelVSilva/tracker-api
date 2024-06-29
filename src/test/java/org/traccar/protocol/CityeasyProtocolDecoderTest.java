package org.traccar.protocol;

import org.junit.jupiter.api.Test;
import org.traccar.ProtocolTest;


public class CityeasyProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new CityeasyProtocolDecoder(null));

        verifyNotNull(decoder, binary(
                "545400853575570249020100033b3430342c34352c31303638312c31313632312c33352c31303638312c31313632322c32332c31303638312c32383938332c32332c31303638312c31313632332c32312c31303638312c32333338312c31372c31303638312c32323538332c31372c31303638312c32363434312c31330000000d352e0d0a"));

        verifyNull(decoder, binary(
                "54540019357557024902010002520704100000000bbe700d0a"));

        verifyNull(decoder, binary(
                "5454001735755702490201434a01000000000c24280d0a"));

        verifyNull(decoder, binary(
                "545400153520000000000100010000000111000D0A"));

        verifyNull(decoder, binary(
                "54540019357557024902000002520704300000000376390d0a"));

        verifyPosition(decoder, binary(
                "5454006135200000000001000332303134313131303039353430392C412C342C4E2C32322E3533373232382C452C3131342E3032323737342C302E312C312E392C35302E363B3436302C302C31303137332C343635322C34310000000B63130D0A"),
                position("2014-11-10 09:54:09.000", true, 22.53723, 114.02277));

        verifyPosition(decoder, binary(
                "5454006135200000000001000432303134313131303039353330362C412C352C4E2C32322E3533373233352C452C3131342E3032323838312C302E322C312E362C35342E313B3436302C302C31303137332C343635322C343100000045EC620D0A"));

        verifyPosition(decoder, binary(
                "5454009035755702490200000332303135303732393033303834352c412c362c4e2c31322e3833353735362c452c37372e3638373039362c302e332c312e322c3931302e303b3430342c34352c31303638312c31313632312c34332c31303638312c31313632332c32312c31303638312c32323538332c32302c31303638312c32333338312c31380000000267370d0a"));

    }

}
