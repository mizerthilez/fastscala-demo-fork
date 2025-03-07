package com.fastscala.demo.docs.fastscala

import com.fastscala.core.FSContext
import com.fastscala.demo.docs.MultipleCodeExamples3Page
import com.fastscala.js.Js
import com.fastscala.scala_xml.js.JS
import com.fastscala.scala_xml.ScalaXmlElemUtils.RichElem

import java.util.Base64

// === code sample ===
class VisualizeUploadedImageAnonymousPage(
                                           contentType: String,
                                           contents: Array[Byte]
                                         ) extends MultipleCodeExamples3Page() {

  override def pageTitle: String = "Visualize Uploaded Image Anonymous Page Example"

  override def renderAllCodeSamples()(implicit fsc: FSContext): Unit = {
    renderCodeSampleAndAutoClosePreviousOne("Source") {
      import com.fastscala.components.bootstrap5.helpers.BSHelpers.*
      JS.rerenderable(rerenderer => implicit fsc => {
        div.border.p_2.rounded.apply {
          h3.apply("Uploaded image:") ++
            <img class="w-100" src={s"data:$contentType;base64, " + Base64.getEncoder.encodeToString(contents)}></img>.mx_auto.my_4.d_block
        }
      }).render()
    }
  }
}
// === code sample ===